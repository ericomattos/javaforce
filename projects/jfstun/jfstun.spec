Buildroot: .
Name: jfstun
Version: 0.3
Release: 1
Summary: STUN/TURN Server
License: LGPL
Distribution: Fedora
Group: Applications/System
BuildArch: @ARCH@

%define _rpmdir ../
%define _rpmfilename %%{NAME}-%%{VERSION}-%%{RELEASE}.@ARCH@.rpm
%define _unpackaged_files_terminate_build 0
%description
STUN/TURN Server
%files
