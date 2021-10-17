// A function to convert kilograms to other measurements (pounds, ounces, grams, stones)

function kilogramsConverter(weigth) {
  if (typeof weigth !== "number") {
    throw new Error("Input must be a valid number.");
  }

  const pounds = weigth * 2.2046;
  const ounces = weigth * 35.274;
  const grams = weigth * 1000;
  const stones = weigth * 0.1574;

  return {
    pounds,
    ounces,
    grams,
    stones,
  };
}
