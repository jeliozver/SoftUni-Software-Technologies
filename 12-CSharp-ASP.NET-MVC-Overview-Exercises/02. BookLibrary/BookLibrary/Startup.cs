using Microsoft.Owin;
using Owin;

[assembly: OwinStartup(typeof(BookLibrary.Startup))]

namespace BookLibrary
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}