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
         checksum: "391dd369abafe60a16a77ab2db1ebbc4a5b71c88f900b8da7dcd9cac74fea8a2"
      )
   ]
)
