/**
 * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
 */
function solution(citations) {
  let answer = 0;
  citations.sort((a, b) => a - b);
  if (citations.length === 1) {
    return citations[0];
  }
  for (let i = 0; i < citations.length; i++) {
    const h = citations.length - i;
    if (citations[i] >= h) {
      answer = h;
      break;
    }
  }
  return answer;
}
console.log(solution([3, 0, 6, 1, 5])); // 3
console.log(solution([0, 0, 0, 0, 0])); // 0
console.log(solution([0])); // 0
console.log(solution([3])); // 3
// console.log(solution([3, 0, 6, 1, 5])); // 3
