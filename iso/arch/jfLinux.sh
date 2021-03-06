#!/bin/bash

sudo pacman -S git make arch-install-scripts squashfs-tools libisoburn dosfstools lynx --needed

git clone https://projects.archlinux.org/archiso.git/

sudo make -C archiso/archiso install

mkdir -p ~/archlive

cp -r /usr/share/archiso/configs/releng/* ~/archlive

#customize begin

echo pacman.conf >> archlive/pacman.conf
echo packages >> archlive/packages.both

#customize end

cd archlive

sudo ./build.sh

cd ..

sudo rm -rf archlive
rm -rf archiso

echo Complete!
