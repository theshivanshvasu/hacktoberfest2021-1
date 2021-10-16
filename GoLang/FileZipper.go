package main

import (
	"archive/zip"
	"io"
	"os"
)

/**
@Description
Zip Function creates a zipped file of the file path provided as an input

@Usage
go run [program.go] [file 1] [file 2] ... [file n]
*/
func Zip() {
	zippedFile, err := os.Create("Zipped.zip") // Create a zip file to put all files
	if err != nil {
		panic("Error Creating .zip file")
	}
	fileArgs := os.Args

	defer func(zippedFile *os.File) {
		err := zippedFile.Close()
		if err != nil {
			panic("Error Closing File")
		}
	}(zippedFile)
	for i := range fileArgs[1:] {

		var writer = zip.NewWriter(zippedFile) //  io.writer as para and returns a Writer
		// Open a file
		fileToComp, err := os.Open(fileArgs[i])
		if err != nil {
			panic("Error Opening File")
		}
		w1, err := writer.Create(fileArgs[i])
		if err != nil {
			panic("Error Creating File")
		}
		if _, err32 := io.Copy(w1, fileToComp); err32 != nil {
			panic(err32)
		}
		func(fileToComp *os.File) {
			err := fileToComp.Close()
			if err != nil {
				panic("Error Creating Root ")
			}
		}(fileToComp)

		rt := writer.Close()
		if rt != nil {
			panic("Error Closing")
		}
	}
}
