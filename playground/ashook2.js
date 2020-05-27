const async_hooks = require("async_hooks");
const { performance, PerformanceObserver } = require("perf_hooks");
const set = new Set();
const hook = async_hooks.createHook({
  init(id, type) {
    if (type === "Timeout") {
      performance.mark(`Timeout-${id}-Init`);
      set.add(id);
    }
  },
  destroy(id) {
    if (set.has(id)) {
      set.delete(id);
      performance.mark(`Timeout-${id}-Destroy`);
      performance.measure(
        `Timeout-${id}`,
        `Timeout-${id}-Init`,
        `Timeout-${id}-Destroy`
      );
    }
  },
});
hook.enable();
const obs = new PerformanceObserver((list, observer) => {
  console.log(list.getEntries()[0]);
  performance.clearMarks();
  observer.disconnect();
});
obs.observe({ entryTypes: ["measure"], buffered: true });
setTimeout(() => {}, 1000);
