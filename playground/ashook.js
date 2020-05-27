const async_hooks = require("async_hooks");
const fs = require("fs");

const asyncHook = async_hooks.createHook({ init });
asyncHook.enable();

function init(asyncId, type, triggerAsyncId, resource) {
  debug(asyncId, type);
}

function debug(...args) {
  fs.writeFileSync(1, `${args}\n`, { flag: "a" });
}
// console.log("hi");

const computeAnswer = async () => {
  123;
};

(async () => {
  await computeAnswer();
})();
