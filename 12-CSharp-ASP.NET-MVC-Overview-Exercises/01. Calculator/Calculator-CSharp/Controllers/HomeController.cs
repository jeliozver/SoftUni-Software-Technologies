using Calculator_CSharp.Models;
using System;
using System.Web.Mvc;

namespace Calculator_CSharp.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index(Calculator calulator)
        {
            return View(calulator);
        }

        [HttpPost]
        public ActionResult Calculate(Calculator calculator)
        {
            calculator.Result = CalculateResult(calculator);

            return RedirectToAction("Index", calculator);
        }

        private decimal CalculateResult(Calculator calculator)
        {
            decimal result = 0m;

            switch (calculator.Operator)
            {
                case "+":
                    result = calculator.LeftOperand + calculator.RightOperand;
                    break;

                case "-":
                    result = calculator.LeftOperand - calculator.RightOperand;
                    break;

                case "*":
                    result = calculator.LeftOperand * calculator.RightOperand;
                    break;

                case "/":
                    if (calculator.RightOperand == 0) return result;
                    result = calculator.LeftOperand / calculator.RightOperand;
                    break;

                case "mod":
                    if (calculator.RightOperand == 0) return result;
                    result = calculator.LeftOperand % calculator.RightOperand;
                    break;

                case "pow":
                    result = (decimal)Math.Pow((double)calculator.LeftOperand, (double)calculator.RightOperand);
                    break;

                case "And":
                    result = (int)calculator.LeftOperand & (int)calculator.RightOperand;
                    break;

                case "Or":
                    result = (int)calculator.LeftOperand | (int)calculator.RightOperand;
                    break;

                case "Xor":
                    result = (int)calculator.LeftOperand ^ (int)calculator.RightOperand;
                    break;

                case "Not":
                    result = ~(int)calculator.LeftOperand;
                    break;

                case "ShiftLeft":
                    result = (int)calculator.LeftOperand << (int)calculator.RightOperand;
                    break;

                case "ShiftRight":
                    result = (int)calculator.LeftOperand >> (int)calculator.RightOperand;
                    break;

                case "What is X% of Y":
                    result = calculator.LeftOperand / 100 * calculator.RightOperand;
                    break;

                case "X is what % of Y":
                    if (calculator.RightOperand != 0)
                    {
                        result = calculator.LeftOperand / calculator.RightOperand * 100;
                    }
                    break;

                case "√X":
                    result = (decimal)Math.Sqrt((double)calculator.LeftOperand);
                    break;

                case "X!":
                    result = CalcFactorial((int)calculator.LeftOperand);
                    break;
            }

            return result;
        }

        public static int CalcFactorial(int number)
        {
            int factorial = 1;

            while (number > 1)
            {
                factorial *= number;
                number--;
            }

            return factorial;
        }
    }
}