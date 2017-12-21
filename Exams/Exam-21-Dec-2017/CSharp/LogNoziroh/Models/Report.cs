namespace LogNoziroh.Models
{
    using System.ComponentModel.DataAnnotations;

    public class Report
    {
        [Key]
        public int Id { get; set; }

        [Required]
        public string Status { get; set; }

        [Required]
        public string Message { get; set; }

        [Required]
        public string Origin { get; set; }
    }
}