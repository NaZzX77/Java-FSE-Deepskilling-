function BlogDetails() {
  const blogs = [
    { id: 1, title: "React Learning", author: "Stephen Biz" },
    { id: 2, title: "Installation", author: "Schwezdneier" }
  ];

  return (
    <div className="section">
      <h2>Blog Details</h2>
      {blogs.map((blog) => (
        <div key={blog.id}>
          <h3>{blog.title}</h3>
          <p>{blog.author}</p>
        </div>
      ))}
    </div>
  );
}

export default BlogDetails;
