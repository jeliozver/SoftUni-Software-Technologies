using System.Web.Mvc;

namespace NumbersFrom1To50.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }
    }
}