function solution(numbers) {
  let allZero = true;
  for (const number of numbers) {
    if (number !== 0) {
      allZero = false;
      break;
    }
  }
  return allZero ? "0" : numbers.map((item) => {
    return {
      k: `${item}`.padEnd(5, item),
      origin: item,
    };
  }).sort((a, b) => b.k - a.k).map((item) => item.origin).join("");
}
