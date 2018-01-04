namespace ProjectRider.Models
{
    using System.Data.Entity;

    public class ProjectRiderDbContext : DbContext
    {
        public virtual IDbSet<Project> Projects { get; set; }

        public ProjectRiderDbContext() : base("ProjectRider")
        {
        }
    }
}