import BlogDetails from "./components/BlogDetails.jsx";
import BookDetails from "./components/BookDetails.jsx";
import CourseDetails from "./components/CourseDetails.jsx";

function App() {
  const showBooks = true;
  const showBlogs = true;
  const showCourses = true;
  let courseContent;

  if (showCourses) {
    courseContent = <CourseDetails />;
  }

  return (
    <div>
      <h1>Blogger App</h1>
      {showBooks && <BookDetails />}
      {showBlogs ? <BlogDetails /> : <h2>Blogs are not available</h2>}
      {courseContent}
    </div>
  );
}

export default App;
