namespace TodoList.Models
{
    using System.Data.Entity;

    public class TodoListDbContext : DbContext
    {
        public virtual IDbSet<Task> Tasks { get; set; }

        public TodoListDbContext() : base("TodoListDb")
        {
        }
    }
}