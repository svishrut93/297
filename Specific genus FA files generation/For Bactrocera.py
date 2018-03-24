
#Generating files containing sequences specific to top level ORDER ; in format of fasta

ippath = 'C:/Users/Admin/PycharmProjects/cleaning file/one1.txt'
oppath = 'C:/Users/Admin/PycharmProjects/cleaning file/sPECIFIC GENUS FA FILES GENERATION/Bactrocera.fa'

ips_file = open(ippath,'r')
ops_file = open(oppath,'w')

# print(days_file.read())
print("----------")
line_count = 0

print(line_count)


def func(ips_file, ops_file):
    line_count = 0
    to_print_or_not = 0
    for line in ips_file:

        if line[0] == '>':
            individual_line = line.split("_")
            if individual_line[5]=='Bactrocera':#CHANGE+1
                to_print_or_not = 1
                from_index = find (line,"_")
                to_write = line[from_index+1:]
                ops_file.write(">"+to_write)
                print(">"+line[from_index+1:])
            else:
                to_print_or_not = 0
        else:
            if to_print_or_not==1:
                to_write = line
                ops_file.write(to_write)
                print(line)

        # if line[0]=='>' &&
        #     to_write = line[10:]
        #     ops_file.write(to_write)
        #     print(line[10:])
        #     print(line_count)
        #     line_count = line_count+1

def find(s, ch):
    list = [i for i, ltr in enumerate(s) if ltr == ch]
    return list[0] #CHANGE+1


print("-----------")
func(ips_file,ops_file)
