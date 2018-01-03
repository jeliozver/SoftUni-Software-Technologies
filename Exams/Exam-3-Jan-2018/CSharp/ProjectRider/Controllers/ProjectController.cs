namespace ProjectRider.Controllers
{
    using Models;
    using System.Data.Entity;
    using System.Linq;
    using System.Web.Mvc;

    [ValidateInput(false)]
    public class ProjectController : Controller
    {
        private ProjectRiderDbContext db = new ProjectRiderDbContext();

        [HttpGet]
        [Route("")]
        public ActionResult Index()
        {
            var projects = db.Projects
                .ToList();

            return View(projects);
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
        public ActionResult Create(Project project)
        {
            if (ModelState.IsValid)
            {
                db.Projects.Add(project);
                db.SaveChanges();
            }

            return Redirect("/");
        }

        [HttpGet]
        [Route("edit/{id}")]
        public ActionResult Edit(int id)
        {
            var project = db.Projects.Find(id);

            if (project == null)
            {
                return Redirect("/");
            }

            return View(project);
        }

        [HttpPost]
        [Route("edit/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult EditConfirm(
            [Bind(Include = "Id,Title,Description,Budget")] Project project)
        {
            if (ModelState.IsValid)
            {
                db.Entry(project).State = EntityState.Modified;
                db.SaveChanges();
            }

            return Redirect("/");
        }

        [HttpGet]
        [Route("delete/{id}")]
        public ActionResult Delete(int id)
        {
            var project = db.Projects.Find(id);

            if (project == null)
            {
                return Redirect("/");
            }

            return View(project);
        }

        [HttpPost]
        [Route("delete/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirm(int id, Project reportModel)
        {
            var project = db.Projects.Find(id);

            if (project == null)
            {
                return Redirect("/");
            }

            db.Projects.Remove(project);
            db.SaveChanges();

            return Redirect("/");
        }
    }
}