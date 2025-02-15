// swift-tools-version:5.3
import PackageDescription

let package = Package(
   name: "library",
   platforms: [
     .iOS(.v14),
   ],
   products: [
      .library(name: "library", targets: ["library"])
   ],
   targets: [
      .binaryTarget(
         name: "library",
         url: "https://github.com/MarceloLuiz12/kmp_library_mlp/releases/download/1.0.0/XCFrameworks.zip",
         checksum: "ebf2b43913ef1032b50afa2586b7057397aad6a8bde48a162b265c94cdd0faed"
      )
   ]
)
