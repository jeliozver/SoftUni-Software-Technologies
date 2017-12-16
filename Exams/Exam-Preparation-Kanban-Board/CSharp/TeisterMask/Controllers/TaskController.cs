namespace TeisterMask.Controllers
{
    using Models;
    using System.Data.Entity;
    using System.Linq;
    using System.Web.Mvc;

    [ValidateInput(false)]
    public class TaskController : Controller
    {
        private TeisterMaskDbContext db = new TeisterMaskDbContext();

        [HttpGet]
        [Route("")]
        public ActionResult Index()
        {
            var tasks = db.Tasks.ToList();

            return View(tasks);
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
        public ActionResult Create(Task task)
        {
            if (ModelState.IsValid)
            {
                db.Tasks.Add(task);
                db.SaveChanges();
                return Redirect("/");
            }

            return View();
        }

        [HttpGet]
        [Route("edit/{id}")]
        public ActionResult Edit(int id)
        {
            var task = db.Tasks.Find(id);

            if (task == null)
            {
                return Redirect("/");
            }

            return View(task);
        }

        [HttpPost]
        [Route("edit/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult EditConfirm(
            [Bind(Include = "Id,Title,Status")] Task task)
        {
            if (ModelState.IsValid)
            {
                db.Entry(task).State = EntityState.Modified;
                db.SaveChanges();
            }

            return Redirect("/");
        }
    }
}