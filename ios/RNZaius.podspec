require 'json'

package = JSON.parse(File.read(File.join(__dir__, 'package.json')))

Pod::Spec.new do |s|
  s.name         = "RNZaius"
  s.version      = package['version']
  s.summary      = package['description']
  s.description  = <<-DESC
                  A bridge for the Zaius Android/iOS APK
                   DESC
  s.homepage     = ""
  s.license      = package['license']
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author       = { "author" => "tech@leciseau.fr" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/LeCiseau/react-native-zaius.git", :tag => "master" }
  s.source_files = "**/*.{h,m}"
  s.requires_arc = true
  s.homepage = "https://github.com/LeCiseau/react-native-zaius"
  s.module_name  = "RNZaius"

  s.dependency "React"
  s.dependency "Zaius", '~> 2.1.0'

end
