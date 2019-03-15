
Pod::Spec.new do |s|
  s.name         = "RNZaius"
  s.version      = "0.0.1"
  s.summary      = "RNZaius"
  s.description  = <<-DESC
                  A bridge for the Zaius Android/iOS APK
                   DESC
  s.homepage     = ""
  s.license      = { :type => "MIT" }
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author       = { "author" => "tech@leciseau.fr" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/LeCiseau/react-native-zaius.git", :tag => "master" }
  s.source_files = "RNZaius/**/*.{h,m}"
  s.requires_arc = true
  s.homepage = "https://github.com/LeCiseau/react-native-zaius"

  s.dependency "React"
  s.dependency "Zaius"

end
