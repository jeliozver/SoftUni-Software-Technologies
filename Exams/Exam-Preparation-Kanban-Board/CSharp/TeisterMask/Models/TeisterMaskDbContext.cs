namespace TeisterMask.Models
{
    using System.Data.Entity;

    public class TeisterMaskDbContext : DbContext
    {
        public virtual IDbSet<Task> Tasks { get; set; }

        public TeisterMaskDbContext() : base("TeisterMask")
        {
        }
    }
}