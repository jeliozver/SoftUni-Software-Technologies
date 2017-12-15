namespace IMDB.Models
{
    using System.Data.Entity;

    public class IMDBDbContext : DbContext
    {
        public virtual IDbSet<Film> Films { get; set; }

        public IMDBDbContext() : base("IMDB")
        {
        }
    }
}