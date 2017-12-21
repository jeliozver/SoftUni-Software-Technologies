namespace ShoppingList.Controllers
{
    using Models;
    using System.Data.Entity;
    using System.Linq;
    using System.Web.Mvc;

    [ValidateInput(false)]
    public class ProductController : Controller
    {
        private ShoppingListDbContext db = new ShoppingListDbContext();

        [HttpGet]
        [Route("")]
        public ActionResult Index()
        {
            var products = db.Products
                .OrderBy(p => p.Priority)
                .ToList();

            return View(products);
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
        public ActionResult Create(Product product)
        {
            if (ModelState.IsValid)
            {
                db.Products.Add(product);
                db.SaveChanges();
            }

            return Redirect("/");
        }

        [HttpGet]
        [Route("edit/{id}")]
        public ActionResult Edit(int? id)
        {
            var product = db.Products.Find(id);

            if (product == null)
            {
                return Redirect("/");
            }

            return View(product);
        }

        [HttpPost]
        [Route("edit/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult EditConfirm(
            [Bind(Include = "Id,Priority,Name,Quantity,Status")] Product product)
        {
            if (ModelState.IsValid)
            {
                db.Entry(product).State = EntityState.Modified;
                db.SaveChanges();
            }

            return Redirect("/");
        }

        [HttpGet]
        [Route("delete/{id}")]
        public ActionResult Delete(int? id)
        {
            var product = db.Products.Find(id);

            if (product == null)
            {
                return Redirect("/");
            }

            return View(product);
        }

        [HttpPost]
        [Route("delete/{id}")]
		[ValidateAntiForgeryToken]
        public ActionResult DeleteConfirm(int? id)
        {
            var product = db.Products.Find(id);

            if (product == null)
            {
                return Redirect("/");
            }

            db.Products.Remove(product);
            db.SaveChanges();

            return Redirect("/");
        }
    }
}