function solution(answers) {
  const p1 = [1, 2, 3, 4, 5];
  const p2 = [2, 1, 2, 3, 2, 4, 2, 5];
  const p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
  const count = {
    p1: {
      who: 1,
      cnt: 0,
    },
    p2: {
      who: 2,
      cnt: 0,
    },
    p3: {
      who: 3,
      cnt: 0,
    },
  };
  answers.forEach((item, index) => {
    if (item === p1[index % p1.length]) {
      count.p1.cnt++;
    }
    if (item === p2[index % p2.length]) {
      count.p2.cnt++;
    }
    if (item === p3[index % p3.length]) {
      count.p3.cnt++;
    }
  });
  const sorted = Object.values(count).sort((a, b) => b.cnt - a.cnt);
  if (sorted[0].cnt !== sorted[1].cnt) {
    return [sorted[0].who];
  } else if (sorted[1].cnt !== sorted[2].cnt) {
    return [sorted[0].who, sorted[1].who];
  } else {
    return [sorted[0].who, sorted[1].who, sorted[2].who];
  }
}
