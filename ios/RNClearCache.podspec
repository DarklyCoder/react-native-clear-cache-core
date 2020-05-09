
Pod::Spec.new do |s|
  s.name         = "RNClearCache"
  s.version      = "1.0.0"
  s.summary      = "RNClearCache"
  s.description  = <<-DESC
                  RNClearCache
                   DESC
  s.homepage     = "https://github.com/DarklyCoder/RNClearCache"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/author/RNClearCache.git", :tag => "master" }
  s.source_files  = "RNClearCache/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

  