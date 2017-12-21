namespace LogNoziroh.Models
{
    using System.Data.Entity;
    public class LogNozirohDbContext : DbContext
    {
        public virtual IDbSet<Report> Reports { get; set; }

        public LogNozirohDbContext() : base("LogNoziroh")
        {
        }
    }
}