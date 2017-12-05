namespace SoftUniBlog.Migrations
{
    using System.Data.Entity.Migrations;
    using Models;

    internal sealed class Configuration : DbMigrationsConfiguration<BlogDbContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = true;
            AutomaticMigrationDataLossAllowed = true;
            ContextKey = "SoftUniBlog.Models.BlogDbContext";
        }

        protected override void Seed(BlogDbContext context)
        {
        }
    }
}