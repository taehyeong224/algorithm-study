function solution(heights) {
  const answer = [];
  const len = heights.length;
  for (let j = len - 1; j >= 0; j--) {
    if (j === 0) {
      answer.push(0);
      break;
    }

    const currentLen = answer.length;
    for (let i = j - 1; i >= 0; i--) {
      if (heights[j] < heights[i]) {
        answer.push(i + 1);
        break;
      }
    }
    if (currentLen === answer.length) {
      answer.push(0);
    }
  }
  return answer.reverse();
}
