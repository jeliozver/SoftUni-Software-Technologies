namespace SoftUniBlog.Controllers
{
    using Microsoft.AspNet.Identity;
    using Models;
    using System;
    using System.Data.Entity;
    using System.Linq;
    using System.Net;
    using System.Web.Mvc;

    public class ArticleController : Controller
    {
        [ActionName("List")]
        [HttpGet]
        public ActionResult ListView()
        {
            using (var db = new BlogDbContext())
            {
                var articles = db.Articles
                    .Include(a => a.Author)
                    .OrderByDescending(d => d.Date)
                    .Take(6)
                    .ToList();

                foreach (var article in articles)
                {
                    article.Content = article
                        .Content
                        .Substring(0, article.Content.Length / 2) + "...";
                }

                return View(articles);
            }
        }

        [Authorize]
        [ActionName("Create")]
        [HttpGet]
        public ActionResult CreateView()
        {
            return View();
        }

        [Authorize]
        [ActionName("Create")]
        [HttpPost]
        public ActionResult CreateAction(Article model)
        {
            if (ModelState.IsValid)
            {
                using (var db = new BlogDbContext())
                {
                    var authorId = User.Identity.GetUserId();

                    model.AuthorId = authorId;
                    model.Date = DateTime.Now;

                    db.Articles.Add(model);
                    db.SaveChanges();
                }

                return RedirectToAction("List");
            }

            return View(model);
        }

        [ActionName("Details")]
        [HttpGet]
        public ActionResult DetailsView(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var db = new BlogDbContext())
            {
                var article = db.Articles
                    .Where(a => a.Id == id)
                    .Include(a => a.Author)
                    .First();

                if (article == null)
                {
                    return HttpNotFound();
                }

                return View(article);
            }
        }

        [Authorize]
        [ActionName("Edit")]
        [HttpGet]
        public ActionResult EditView(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var db = new BlogDbContext())
            {
                var article = db.Articles.Find(id);

                if (!IsAuthorized(article))
                {
                    return new HttpStatusCodeResult(HttpStatusCode.Forbidden);
                }

                if (article == null)
                {
                    return HttpNotFound();
                }

                var model = new ArticleViewModel
                {
                    Id = article.Id,
                    Title = article.Title,
                    Content = article.Content,
                    AuthorId = article.AuthorId
                };

                return View(model);
            }
        }

        [Authorize]
        [ActionName("Edit")]
        [HttpPost]
        public ActionResult EditAction(ArticleViewModel model)
        {
            if (ModelState.IsValid)
            {
                using (var db = new BlogDbContext())
                {
                    var article = db.Articles.Find(model.Id);

                    if (!IsAuthorized(article))
                    {
                        return new HttpStatusCodeResult(HttpStatusCode.Forbidden);
                    }

                    if (article == null)
                    {
                        return HttpNotFound();
                    }

                    article.Title = model.Title;
                    article.Content = model.Content;
                    article.Date = DateTime.Now;

                    db.Entry(article).State = EntityState.Modified;
                    db.SaveChanges();

                    return RedirectToAction("List");
                }
            }

            return View(model);
        }

        [Authorize]
        [ActionName("Delete")]
        [HttpGet]
        public ActionResult DeleteView(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var db = new BlogDbContext())
            {
                var article = db.Articles.Find(id);

                if (!IsAuthorized(article))
                {
                    return new HttpStatusCodeResult(HttpStatusCode.Forbidden);
                }

                if (article == null)
                {
                    return HttpNotFound();
                }

                return View(article);
            }
        }

        [Authorize]
        [ActionName("Delete")]
        [HttpPost]
        public ActionResult DeleteAction(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var db = new BlogDbContext())
            {
                var article = db.Articles.Find(id);

                if (!IsAuthorized(article))
                {
                    return new HttpStatusCodeResult(HttpStatusCode.Forbidden);
                }

                if (article == null)
                {
                    return HttpNotFound();
                }

                db.Articles.Remove(article);
                db.SaveChanges();

                return RedirectToAction("List");
            }
        }

        private bool IsAuthorized(Article model)
        {
            var isAdmin = User.IsInRole("Admin");
            var isAuthor = model.IsAuthor(User.Identity.GetUserId());

            return isAdmin || isAuthor;
        }
    }
}