<?php

namespace CalculatorBundle\Controller;

use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Security;
use CalculatorBundle\Entity\Calculator;
use CalculatorBundle\Form\CalculatorType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class CalculatorController extends Controller
{
    /**
     * @param Request $request
     *
     * @Route("/", name="index")
     *
     * @return \Symfony\Component\HttpFoundation\Response
     *
     */
    public function index(Request $request)
    {
        $calculator = new Calculator();

        $form = $this->createForm(CalculatorType:: class, $calculator);

        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid())
        {
            $leftOperand = $calculator->getLeftOperand();
            $rightOperand = $calculator->getRightOperand();
            $operator = $calculator->getOperator();

            $result = 0;

            switch ($operator)
            {
                case '+':
                    $result = $leftOperand + $rightOperand;
                    break;
                case '-':
                    $result = $leftOperand - $rightOperand;
                    break;
                case '*':
                    $result = $leftOperand * $rightOperand;
                    break;
                case '/':
                    if ($rightOperand == 0) {
                        $result = "Cannot divide by zero!";
                        echo "<h1>Error: Cannot divide by zero!</h1>";
                    } else {
                        $result = $leftOperand / $rightOperand;
                    }
                    break;
                case 'mod':
                    $result = $leftOperand % $rightOperand;
                    break;
                case 'pow':
                    $result = pow($leftOperand, $rightOperand);
                    break;
                case 'And':
                    $result = intval($leftOperand) & intval($rightOperand);
                    break;
                case 'Or':
                    $result = intval($leftOperand) | intval($rightOperand);
                    break;
                case 'Xor':
                    $result = intval($leftOperand) ^ intval($rightOperand);
                    break;
                case 'Not':
                    $result = ~ intval($leftOperand);
                    break;
                case 'ShiftLeft':
                    $result = intval($leftOperand) << intval($rightOperand);
                    break;
                case 'ShiftRight':
                    $result = intval($leftOperand) >> intval($rightOperand);
                    break;
                case 'What is X% of Y':
                    $result = $leftOperand / 100 * $rightOperand;
                    break;
                case 'X is what % of Y':
                    if ($rightOperand != 0) {
                        $result = $leftOperand / $rightOperand * 100;
                    }
                    break;
                case '√X':
                    $result = sqrt($leftOperand);
                    break;
                case 'X!':
                    function calcFactorial($n)
                    {
                        $factorial = 1;
                        while ($n > 1)
                        {
                            $factorial *= $n;
                            $n--;
                        }

                        return $factorial;
                    }
                    $result = calcFactorial($leftOperand);
                    break;
            }

            return $this->render('calculator/index.html.twig',
                ['result' => $result, 'calculator' => $calculator, 'form' => $form->createView()]);
        }

        return $this->render('calculator/index.html.twig',
            ['form' => $form->createView()]);
    }
}