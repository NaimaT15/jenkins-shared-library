def call(String imageName, String tag, String dockerfilePath = 'Dockerfile', String contextPath = '.') {
    sh """
    docker run --rm \
      -v \$(pwd):/workspace \
      gcr.io/kaniko-project/executor:latest \
      --dockerfile=/workspace/${dockerfilePath} \
      --context=dir:///workspace/${contextPath} \
      --destination=${imageName}:${tag}
    """
}
