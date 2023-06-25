FROM maven:3.8.1-openjdk-8

# Set the working directory
WORKDIR /app

# Copy the project files into the container
COPY . .

# Run Maven clean install
RUN mvn clean install

# Run the test command
CMD ["mvn", "test"]
