function solution(progresses, speeds) {
  const answer = [];
  const days = progresses.map((element, i) => {
    const max = 100;
    const c = Number(max - element);
    const d = Math.ceil(c / speeds[i]);
    return (element + (d * speeds[i]) >= max) ? d : d + 1;
  });
  for (let i = 0; i < days.length; i++) {
    const item = days[i];
    let count = 1;
    for (let j = i + 1; j < days.length; j++) {
      const val = days[j];
      if (item < val) {
        break;
      }
      count += 1;
    }
    i = i + count - 1;
    answer.push(count);
  }

  return answer;
}
const result = solution([93, 30, 55], [1, 30, 5]); // [2, 1]
console.log(result);
