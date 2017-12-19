namespace AnimeList.Controllers
{
    using System.Linq;
    using System.Web.Mvc;
    using Models;

    [ValidateInput(false)]
    public class AnimeController : Controller
    {
        private AnimeListDbContext db = new AnimeListDbContext();

        [HttpGet]
        [Route("")]
        public ActionResult Index()
        {
            var animeList = db
                .Animes.OrderBy(r => r.Rating)
                .ToList();

            return View(animeList);
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
        public ActionResult Create(Anime anime)
        {
            if (ModelState.IsValid)
            {
                db.Animes.Add(anime);
                db.SaveChanges();
            }

            return Redirect("/");
        }

        [HttpGet]
        [Route("delete/{id}")]
        public ActionResult Delete(int? id)
        {
            var anime = db.Animes.Find(id);

            if (anime == null)
            {
                return Redirect("/");
            }

            return View(anime);
        }

        [HttpPost]
        [Route("delete/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirm(int? id)
        {
            var anime = db.Animes.Find(id);

            if (anime == null)
            {
                return Redirect("/");
            }

            db.Animes.Remove(anime);
            db.SaveChanges();

            return Redirect("/");
        }
    }
}