namespace TrainSystem.Controllers
{
    using Models;
    using System.Data.Entity;
    using System.Linq;
    using System.Web.Mvc;

    [ValidateInput(false)]
    public class TripController : Controller
    {
        private TrainSystemDbContext db = new TrainSystemDbContext();

        [HttpGet]
        [Route("")]
        public ActionResult Index()
        {
            var trips = db.Trips
                .ToList();

            return View(trips);
        }

        [HttpGet]
        [Route("create")]
        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [Route("create")]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Trip trip)
        {
            if (ModelState.IsValid)
            {
                db.Trips.Add(trip);
                db.SaveChanges();
            }

            return Redirect("/");
        }

        [HttpGet]
        [Route("edit/{id}")]
        public ActionResult Edit(int id)
        {
            var trip = db.Trips.Find(id);

            if (trip == null)
            {
                return Redirect("/");
            }

            return View(trip);
        }

        [HttpPost]
        [Route("edit/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult EditConfirm(
            [Bind(Include = "Id,Origin,Destination,Business,Economy")] Trip trip)
        {
            if (ModelState.IsValid)
            {
                db.Entry(trip).State = EntityState.Modified;
                db.SaveChanges();
            }

            return Redirect("/");
        }

        [HttpGet]
        [Route("delete/{id}")]
        public ActionResult Delete(int id)
        {
            var trip = db.Trips.Find(id);

            if (trip == null)
            {
                return Redirect("/");
            }

            return View(trip);
        }

        [HttpPost]
        [Route("delete/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirm(int id, Trip tripModel)
        {
            var trip = db.Trips.Find(id);

            if (trip == null)
            {
                return Redirect("/");
            }

            db.Trips.Remove(trip);
            db.SaveChanges();

            return Redirect("/");
        }
    }
}