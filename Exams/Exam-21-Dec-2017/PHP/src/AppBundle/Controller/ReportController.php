<?php

namespace AppBundle\Controller;

use AppBundle\Entity\Report;
use AppBundle\Form\ReportType;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class ReportController extends Controller
{
    /**
     * @Route("/", name="index")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function index()
    {
        $em = $this->getDoctrine()->getRepository(Report::class);
        $reports = $em->findAll();

        return $this
            ->render('report/index.html.twig',
                ['reports' => $reports]);
    }

    /**
     * @Route("/details/{id}", name="details")
     *
     * @param $id
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function details($id, Request $request)
    {
        $report = $this
            ->getDoctrine()
            ->getRepository(Report::class)
            ->find($id);

        if ($report == null) {
            return $this->redirectToRoute('index');
        }

        $form = $this
            ->createForm(ReportType::class, $report);
        $form->handleRequest($request);


        return $this->render('report/details.html.twig',
            ['report' => $report, 'form' => $form->createView()]);
    }

    /**
     * @param Request $request
     * @Route("/create", name="create")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function create(Request $request)
    {
        $report = new report();

        $form = $this
            ->createForm(reportType::class, $report);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            if ($report->getStatus() == null
                || $report->getMessage() == null
                || $report->getOrigin() == null) {
                return $this->redirectToRoute('create');
            }

            $em = $this->getDoctrine()->getManager();

            $em->persist($report);
            $em->flush();

            return $this->redirectToRoute('index');
        }

        return $this->render('report/create.html.twig',
            ['form' => $form->createView()]);
    }

    /**
     * @Route("/edit/{id}", name="edit")
     *
     * @param $id
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function edit($id, Request $request)
    {
        $report = $this
            ->getDoctrine()
            ->getRepository(Report::class)
            ->find($id);

        if ($report == null) {
            return $this->redirectToRoute('index');
        }

        $form = $this
            ->createForm(ReportType::class, $report);

        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            if ($report->getStatus() == null
                || $report->getMessage() == null
                || $report->getOrigin() == null) {
                return $this->redirectToRoute('index');
            }

            $em = $this->getDoctrine()->getManager();

            $em->merge($report);
            $em->flush();

            return $this->redirectToRoute('index');
        }

        return $this->render('report/edit.html.twig',
            ['report' => $report, 'form' => $form->createView()]);
    }

    /**
     * @Route("/delete/{id}", name="delete")
     *
     * @param $id
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function delete($id, Request $request)
    {
        $report = $this
            ->getDoctrine()
            ->getRepository(Report::class)
            ->find($id);

        if ($report == null) {
            return $this->redirectToRoute('index');
        }

        $form = $this
            ->createForm(ReportType::class, $report);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();

            $em->remove($report);
            $em->flush();

            return $this->redirectToRoute('index');
        }

        return $this->render('report/delete.html.twig',
            ['report' => $report, 'form' => $form->createView()]);
    }
}
