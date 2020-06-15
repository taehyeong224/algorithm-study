const solution = (n, m = n % 3, next = Math.floor(n / 3)) => {
  return !n ? "" : !m ? solution(next - 1) + 4 : solution(next) + m;
};
