
Pod::Spec.new do |s|
  s.name         = "RNReactNativeZaius"
  s.version      = "0.0.1"
  s.summary      = "RNReactNativeZaius"
  s.description  = <<-DESC
                  A bridge for the Zaius Android/iOS APK
                   DESC
  s.homepage     = ""
  s.license      = { :type => "MIT" }
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author       = { "author" => "tech@leciseau.fr" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/LeCiseau/react-native-zaius.git", :tag => "master" }
  s.source_files = "RNReactNativeZaius/**/*.{h,m}"
  s.requires_arc = true

  s.dependency "React"
  s.dependency "Zaius"

end
