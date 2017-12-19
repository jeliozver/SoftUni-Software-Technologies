namespace AnimeList.Models
{
    using System.Data.Entity;

    public class AnimeListDbContext : DbContext
    {
        public virtual IDbSet<Anime> Animes { get; set; }

        public AnimeListDbContext() : base("AnimeList")
        {
        }
    }
}