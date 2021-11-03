# sample-app

Spring Boot was used for this app with spring data JPA and spring boot web dependencies. The reason is that it gives out-of-the-box ready configurations that are sufficient for most situations. It speeds up development and gives production-ready applications.\
If I had more time I would definitely finish up writing unit tests, I would add swagger documentation for APIs, logging, and maybe customize the spring actuator settings. The step above that would be to write integration tests and custom exceptions with error codes.\
Building this app I lost more time than I expected on figuring out the model for objects based on provided JSON data. Next time I would try to optimize that for sure. Maybe I would try to bootstrap data from JSON examples as early as possible. Of course, the fastest way, for sure, would be to ask the person who modeled that.
