require 'json'

package = JSON.parse(File.read(File.join(__dir__, 'package.json')))

Pod::Spec.new do |s|
  s.name         = "RNZaius"
  s.version      = package['version']
  s.summary      = package['description']
  s.description  = <<-DESC
                  A bridge for the Zaius Android/iOS APK
                   DESC
  s.license      = package['license']
  s.author       = { "author" => "tech@leciseau.fr" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/LeCiseau/react-native-zaius.git", :tag => "master" }
  s.source_files = "ios/*.{h,m}"
  s.requires_arc = true
  s.homepage = package['homepage']
  s.module_name  = "RNZaius"

  s.dependency "React"
  s.dependency "Zaius", '~> 2.1.0'

end
