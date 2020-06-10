function solution(numbers) {
  const numberList = numbers.split("");
  const answers = findPrimeNumbers(numberList);

  return [...new Set(answers)].length;
}

function findPrimeNumbers(numberList, prevNumber) {
  console.log(numberList);
  const frontPaddingNumber = prevNumber || "";

  return numberList.reduce((primeNumbers, number, index) => {
    if (isPrimeNumber(Number(frontPaddingNumber + number))) {
      primeNumbers.push(Number(frontPaddingNumber + number));
    }

    const nextNumberList = [...numberList];
    nextNumberList.splice(index, 1);

    const result = findPrimeNumbers(
      nextNumberList,
      frontPaddingNumber + number,
    );
    primeNumbers.push(...result);

    return primeNumbers;
  }, []);
}

function isPrimeNumber(number) {
  const notPrime = [0, 1];
  if (notPrime.includes(number)) return false;

  for (let i = 2; i * i <= number; i++) {
    if (number % i === 0) return false;
  }

  return true;
}
console.log(solution("9999999"));
