namespace LogNoziroh.Controllers
{
    using Models;
    using System.Data.Entity;
    using System.Linq;
    using System.Web.Mvc;

    [ValidateInput(false)]
    public class ReportController : Controller
    {
        private LogNozirohDbContext db = new LogNozirohDbContext();

        [HttpGet]
        [Route("")]
        public ActionResult Index()
        {
            var reports = db.Reports.ToList();

            return View(reports);
        }

        [HttpGet]
        [Route("details/{id}")]
        public ActionResult Details(int id)
        {
            var report = db.Reports.Find(id);

            if (report == null)
            {
                return Redirect("/");
            }

            return View(report);
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
        public ActionResult CreateConfrim(Report report)
        {
            if (ModelState.IsValid)
            {
                db.Reports.Add(report);
                db.SaveChanges();
            }

            return Redirect("/");
        }

        [HttpGet]
        [Route("edit/{id}")]
        public ActionResult Edit(int id)
        {
            var report = db.Reports.Find(id);

            if (report == null)
            {
                return Redirect("/");
            }

            return View(report);
        }

        [HttpPost]
        [Route("edit/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult EditConfirm([Bind(Include = "Id,Status,Message,Origin")] Report report)
        {
            if (ModelState.IsValid)
            {
                db.Entry(report).State = EntityState.Modified;
                db.SaveChanges();
            }

            return Redirect("/");
        }

        [HttpGet]
        [Route("delete/{id}")]
        public ActionResult Delete(int id)
        {
            var report = db.Reports.Find(id);

            if (report == null)
            {
                return Redirect("/");
            }

            return View(report);
        }

        [HttpPost]
        [Route("delete/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirm(int id)
        {
            var report = db.Reports.Find(id);

            if (report == null)
            {
                return Redirect("/");
            }

            db.Reports.Remove(report);
            db.SaveChanges();

            return Redirect("/");
        }
    }
}