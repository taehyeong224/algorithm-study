function solution(arrangement) {
  const stack = new Stack();
  const pivot = "R";
  let answer = 0;
  [...arrangement.replaceAll("()", pivot)].forEach((item) => {
    if (item === "(") {
      stack.push(item);
    }
    if (item === ")") {
      answer += 1;
      stack.pop();
    }
    if (item === pivot) {
      answer += stack.len();
    }
  });
  return answer;
}
String.prototype.replaceAll = function (org, dest) {
  return this.split(org).join(dest);
};
class Stack {
  constructor() {
    this.data = [];
  }

  push(element) {
    this.data.push(element);
  }

  pop() {
    const last = this.data[this.len() - 1];
    this.data.splice(-1, 1);
    return last;
  }

  len() {
    return this.data.length;
  }
}

console.log(solution("()(((()())(())()))(())"));
