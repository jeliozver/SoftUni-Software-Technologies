﻿namespace SoftUniBlog.Models
{
    using System;
    using System.ComponentModel.DataAnnotations;

    public class ArticleViewModel
    {
        public int Id { get; set; }

        [Required]
        [StringLength(50)]
        public string Title { get; set; }

        [Required]
        public string Content { get; set; }

        public DateTime Date { get; set; }

        public string AuthorId { get; set; }
    }
}