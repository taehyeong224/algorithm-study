function solution(priorities, location) {
  const originObjAry = priorities.map((item, index) => {
    return {
      index,
      item,
    };
  });
  let answer = 0;
  const print = [];
  while (true) {
    const element = originObjAry.shift();
    const len = originObjAry.length;
    let hasBig = false;
    for (let i = 0; i < len; i++) {
      if (element.item < originObjAry[i].item) {
        hasBig = true;
        break;
      }
    }
    if (hasBig) {
      originObjAry.push(element);
    } else {
      print.push(element);
      if (element.index === location) {
        answer = print.length;
        break;
      }
    }
  }
  return answer;
}
console.log(solution([2, 1, 3, 2], 2));
