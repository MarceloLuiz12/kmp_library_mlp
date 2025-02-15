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
         checksum: "13edd9ebf3fcff01a977644de4f80c6b1c6d514311b36d56fadb58fd45951a78"
      )
   ]
)
