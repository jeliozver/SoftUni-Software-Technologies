<?php

namespace AppBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Trip
 *
 * @ORM\Table(name="trips")
 * @ORM\Entity(repositoryClass="AppBundle\Repository\TripRepository")
 */
class Trip
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="origin", type="string", length=255)
     */
    private $origin;

    /**
     * @var string
     *
     * @ORM\Column(name="destination", type="string", length=255)
     */
    private $destination;

    /**
     * @var int
     *
     * @ORM\Column(name="business", type="integer")
     */
    private $business;

    /**
     * @var int
     *
     * @ORM\Column(name="economy", type="integer")
     */
    private $economy;


    /**
     * Get id
     *
     * @return int
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set origin
     *
     * @param string $origin
     *
     * @return Trip
     */
    public function setOrigin($origin)
    {
        $this->origin = $origin;

        return $this;
    }

    /**
     * Get origin
     *
     * @return string
     */
    public function getOrigin()
    {
        return $this->origin;
    }

    /**
     * Set destination
     *
     * @param string $destination
     *
     * @return Trip
     */
    public function setDestination($destination)
    {
        $this->destination = $destination;

        return $this;
    }

    /**
     * Get destination
     *
     * @return string
     */
    public function getDestination()
    {
        return $this->destination;
    }

    /**
     * Set business
     *
     * @param integer $business
     *
     * @return Trip
     */
    public function setBusiness($business)
    {
        $this->business = $business;

        return $this;
    }

    /**
     * Get business
     *
     * @return int
     */
    public function getBusiness()
    {
        return $this->business;
    }

    /**
     * Set economy
     *
     * @param integer $economy
     *
     * @return Trip
     */
    public function setEconomy($economy)
    {
        $this->economy = $economy;

        return $this;
    }

    /**
     * Get economy
     *
     * @return int
     */
    public function getEconomy()
    {
        return $this->economy;
    }
}

