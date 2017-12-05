using Microsoft.Owin;

[assembly: OwinStartup(typeof(SoftUniBlog.Startup))]

namespace SoftUniBlog
{
    using Migrations;
    using Models;
    using Owin;
    using System.Data.Entity;

    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            Database.SetInitializer(
                new MigrateDatabaseToLatestVersion<BlogDbContext, Configuration>());

            ConfigureAuth(app);
        }
    }
}