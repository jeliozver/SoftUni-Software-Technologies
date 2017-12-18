namespace ShoppingList.Models
{
    using System.Data.Entity;

    public class ShoppingListDbContext : DbContext
    {
        public virtual IDbSet<Product> Products { get; set; }

        public ShoppingListDbContext() : base("ShoppingList")
        {
        }
    }
}