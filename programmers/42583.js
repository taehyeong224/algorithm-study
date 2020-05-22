function solution(bridge_length, weight, truck_weights) {
  let time = 0;
  let i = 0;
  const reducer = (accumulator, currentValue) => accumulator + currentValue;
  const len = truck_weights.length;
  const passAry = [];
  const timeObj = {};
  const doing = {};
  while (1) {
    Object.keys(timeObj).map((key) => {
      if (timeObj[key] + 1 > bridge_length) {
        passAry.push(key);
        delete timeObj[key];
        delete doing[key];
      } else {
        timeObj[key] += 1;
      }
    });

    let currentW = Object.values(doing).reduce(reducer, 0);
    if (currentW + truck_weights[0] <= weight) {
      const item = truck_weights.shift();
      currentW += item;
      timeObj[i] = 1;
      doing[i] = item;
      i++;
    }
    time++;
    if (len === passAry.length && currentW === 0) {
      break;
    }
  }
  return time;
}
