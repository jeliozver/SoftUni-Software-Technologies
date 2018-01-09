namespace TrainSystem.Models
{
    using System.Data.Entity;

    public class TrainSystemDbContext : DbContext
    {
        public virtual IDbSet<Trip> Trips { get; set; }

        public TrainSystemDbContext() : base("TrainSystem")
        {
        }
    }
}